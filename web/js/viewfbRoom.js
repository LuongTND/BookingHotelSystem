const avg = document.querySelector('.star-count .avg');
const ratingCount = document.querySelector('.rating-count .count');
const progressLine = document.querySelectorAll('.progress-line');
const countReview = document.querySelector('.count-review span');
const writeBtn = document.querySelector('.btn-write');
const reviewContent = document.querySelector('.review-content');
const username = document.getElementById('name');
const feedback = document.getElementById('feedback');
const submitBtn = document.querySelector('.submit');
const feedbackBox = document.querySelector('.feedback-user');
const starDiv = feedbackBox.querySelector('.stars');
const closeFeedback = document.querySelector('.close-btn .fas');
var closeFbForm = document.querySelector('.close-fbForm');
var ratingBox = document.querySelector('.rating-box');
const viewFeedbackButtons = document.querySelectorAll('.view-feedback');
const redirectButton = document.getElementById('redirect-button');

redirectButton.addEventListener('click', () => {
  window.location.href = 'showRoomCustomer';
});

// Xử lý sự kiện click cho từng nút "view-feedback"
viewFeedbackButtons.forEach((button, index) => {
  button.addEventListener('click', () => {
    // Lấy phần phản hồi tương ứng với item được bấm vào
    const feedback = document.querySelectorAll('.rating-box')[index];

    // Hiển thị phần phản hồi
    feedback.style.display = 'block';
  });
});
closeFbForm.addEventListener('click', function() {
    ratingBox.style.display = 'none'; // Ẩn rating-box
  });


// rating 5 star when user not click
const numberStar = 5;
let userRatingStar = 5;
// initialize rating object
let ratingStars = {
    numRatings: 0,
    avgRating: 0,
};
// use for update time of feedback
let timeouts = [];
// set default value
setDefaultRating();
// set rating when page loaded
calcRating();

// initialize number of stars "5stars:0 4stars:0 3stars:0"
Array.from({ length: numberStar }, (_, i) => {
    let number = ++i; // value: 1,2,3,4,5

    ratingStars[`${number}stars`] = 0;
});
// console.log(ratingStars);

// SHOW/HIDE feedback
writeBtn.addEventListener('click', () => {
    feedbackBox.classList.add('show');
});
closeFeedback.addEventListener('click', setDefaultRating);

// submit feedback
submitBtn.addEventListener('click', () => {
    if (username.value !== '' && feedback.value !== '') {
        const options = {
            timeZone: 'Asia/Ho_Chi_Minh',
            hour: 'numeric',
            minute: 'numeric',
            second: 'numeric',
            weekday: 'long',
            year: 'numeric',
            month: 'long',
            day: 'numeric',
        };
        let time = new Date().toLocaleString('en-US', options);

        reviewContent.insertAdjacentHTML(
            'afterbegin',
            `
        <div class="user-review">
            <div class="user-rating">
                <div class="username">${username.value}</div>
                <div class="stars">
                    ${setStars(userRatingStar)}
                </div>
            </div>
            <div class="comment-content">${feedback.value}</div>
            <time datetime="${time}" title="${time}">Just now</time>
        </div>
        `
        );

        // CALC RATING AND SET TO DOM
        ratingStars[`${userRatingStar}stars`]++;
        ratingStars.numRatings++;
        calcRating();
        // UPDATE TIME FOR FEEDBACK
        for (let time of timeouts) {
            clearInterval(time);
        }
        timeouts = []; // reset
        updateTimeAgo(); // update again time for comment
        // set default value
        setDefaultRating();
    }
});

// set rating DOM
function calcRating() {
    let sumStars = 0;

    let indexProgress = 0;
    const barItems = document.querySelectorAll('.rating-bar .bar-item');
    for (let number = numberStar; number >= 1; number--) {
        let percent = 0;

        const numberOfStars = ratingStars[`${number}stars`];
        if (numberOfStars) {
            sumStars += number * numberOfStars;
            percent = ((numberOfStars / ratingStars.numRatings) * 100).toFixed(
                1
            );
        }

        barItems[indexProgress].querySelector(
            '.progress-line'
        ).style.width = `${percent}%`;
        barItems[indexProgress].querySelector(
            '.percent'
        ).textContent = `${percent}%`;

        indexProgress++;
    }

    if (ratingStars.numRatings) {
        ratingStars.avgRating = (sumStars / ratingStars.numRatings).toFixed(1);
    }

    document.querySelector('.rating-count .count').textContent =
        ratingStars.numRatings;
    document.querySelector('.count-review span').textContent =
        ratingStars.numRatings;
    document.querySelector('.star-count span').textContent =
        ratingStars.avgRating;
    document.querySelector('.avg-stars').innerHTML = setStars(
        ratingStars.avgRating
    );
}

function setDefaultRating() {
    starDiv.innerHTML = '';
    feedbackBox.classList.remove('show');
    username.value = '';
    feedback.value = '';
    userRatingStar = 5;

    Array.from({ length: numberStar }, (_, i) => {
        let number = ++i; // value: 1,2,3,4,5

        const starEle = document.createElement('i');
        starEle.classList.add('fas', 'fa-star', 'fa-fw');
        starEle.dataset.rating = number;

        starEle.addEventListener('click', () => {
            handleRating(number);
        });
        starDiv.appendChild(starEle);
    });
}
function handleRating(number) {
    const stars = feedbackBox.querySelectorAll('.stars i');
    userRatingStar = number;
    stars.forEach((star) => {
        if (number < star.dataset.rating) {
            star.classList.remove('fas');
            star.classList.add('far');
        } else {
            star.classList.add('fas');
            star.classList.remove('far');
        }
    });
}
function setStars(number) {
    let stars = '';
    Array.from({ length: numberStar }, (_, i) => {
        let starNth = 0;
        starNth = ++i;

        stars += `${
            number >= starNth
                ? "<i class='fas fa-fw fa-star'></i>"
                : number >= starNth - 0.5
                ? "<i class='fas fa-fw fa-star-half'></i>"
                : "<i class='far fa-fw fa-star'></i>"
        }`;
    });

    return stars;
}

function time_seconds(time) {
    let current = new Date().toLocaleString('en-US', {
        timeZone: 'Asia/Ho_Chi_Minh',
    });
    let cur_time = Date.parse(current); // ms
    let time_ago = Date.parse(time); // ms
    let time_elapsed = (cur_time - time_ago) / 1000; //seconds
    return time_elapsed;
}
function time_elapsed_string(time) {
    let time_elapsed = time_seconds(time);
    let seconds = time_elapsed;
    let minutes = Math.floor(time_elapsed / 60);
    let hours = Math.floor(time_elapsed / 3600);
    let days = Math.floor(time_elapsed / 86400);
    let weeks = Math.floor(time_elapsed / 604800);
    let months = Math.floor(time_elapsed / (3600 * 24 * 30));
    let years = Math.floor(time_elapsed / (3600 * 24 * 365));
    if (seconds < 60) {
        return 'just now';
    } else if (minutes < 60) {
        console.log('minutes', minutes);
        if (minutes == 1) return '1 minute ago';
        else return `${minutes} minutes ago`;
    } else if (hours < 24) {
        if (hours == 1) return 'an hour ago';
        else return `${hours} hours ago`;
    } else if (days < 7) {
        if (days == 1) return 'yesterday';
        else return `${days} days ago`;
    } else if (weeks < 4.3) {
        if (weeks == 1) return 'a week ago';
        else return `${weeks} weeks ago`;
    } else if (months < 12) {
        if (months == 1) return 'a month ago';
        else return `${months} months ago`;
    } else {
        if (years == 1) return 'one year ago';
        else return `${years} years ago`;
    }
}

function updateTimeAgo() {
    const dateTimeEle = document.querySelectorAll('time[datetime]');
    dateTimeEle.forEach((time) => {
        const datetime = time.getAttribute('datetime');

        const timeAgo = time_elapsed_string(datetime);
        time.textContent = timeAgo;

        const timeSeconds = time_seconds(datetime);
        let hours = timeSeconds / 3600;
        if (hours >= 1) {
            timeouts.push(
                setInterval(() => {
                    setTimeAgo(time, datetime);
                }, 60 * 1000 * 60) // update time after one hour
            );
        } else {
            timeouts.push(
                setInterval(() => {
                    setTimeAgo(time, datetime);
                }, 60 * 1000) //update time after one minute
            );
        }
    });
}
function setTimeAgo(ele, datetime) {
    const timeAgo = time_elapsed_string(datetime);
    ele.textContent = timeAgo;
}
