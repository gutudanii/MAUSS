// JavaScript functionality goes here

// Function to toggle login popup
const togglePopup = () => {
    const loginPopup = document.querySelector('.login-popup-overlay');
    loginPopup.style.display = loginPopup.style.display === 'none' ? 'flex' : 'none';
};

// Add event listener to login button
document.querySelector('.login-button').addEventListener('click', togglePopup);

// Add event listener to close button
document.querySelector('.login-close-button').addEventListener('click', togglePopup);

function toggleSection(sectionId) {
    const sections = document.querySelectorAll('section');
    sections.forEach(section => {
        if (section.id === sectionId) {
            section.classList.add('active');
        } else {
            section.classList.remove('active');
        }
    });
}

let currentImageIndex = 0;
const images = ['/images/activity/act1.jpg', '/images/activity/act2.jpg', '/images/activity/act3.jpg', '/images/activity/act4.jpg', '/images/activity/act5.jpeg', '/images/activity/act6.jpg', '/images/activity/act7.jpg']; // Replace with actual image URLs

function handlePrevImage() {
    currentImageIndex = (currentImageIndex === 0 ? images.length - 1 : currentImageIndex - 1);
    updateImage();
}

function handleNextImage() {
    currentImageIndex = (currentImageIndex === images.length - 1 ? 0 : currentImageIndex + 1);
    updateImage();
}

function updateImage() {
    const imageContainers = document.querySelectorAll('.image-container img');
    imageContainers[0].src = images[(currentImageIndex - 1 + images.length) % images.length];
    imageContainers[1].src = images[currentImageIndex];
    imageContainers[2].src = images[(currentImageIndex + 1) % images.length];
}

const announcements = [
    {
        id: 1,
        title: 'REGISTRATION FOR NEXT SEMESTER IS ABOUT TO START NOW GET READY',
        author: 'Author 1',
        date: 'Feb 1, 2024',
        description: 'This code adds Font Awesome icons for the previous and next buttons in the pagination section for both announcements and events.',
        imageUrl: '/images/home.jpg',
    },
    {
        id: 2,
        title: 'LOREM IPSUM COGITIFA FA AFFAEF AFAFA AFAAFAF AFA FAFGRA AASD',
        author: 'Author 2',
        date: 'Mar 2, 2024',
        description: 'Description of Announcement 2',
        imageUrl: '/images/logo.png',
    },
    {
        id: 3,
        title: 'Announcement 3',
        author: 'Author 3',
        date: 'Jan 2, 2024',
        description: 'Description of Announcement 3',
        imageUrl: '/images/home.jpg',
    },
    // Add more announcements as needed
];

const events = [
    {
        name: 'STEM CENTER AUDITION IN OUR COMPOUND/STUDENTS BATTLE',
        date: { day: '19', month: 'May' },
        time: '10:00 AM',
        description: 'This code adds Font Awesome icons for the previous and next buttons in the pagination section for both announcements',
    },
    {
        name: 'LOREM IPSUM COGITIFA FA AFFAEF AFAFA AFAAFAF AFA FAFGRA AASD',
        date: { day: '20', month: 'Mar' },
        time: '2:00 PM',
        description: 'This code adds Font Awesome icons for the previous and next buttons in the pagination section for both announcements',
    },
    {
        name: 'Event 3',
        date: { day: '20', month: 'Apr' },
        time: '2:00 PM',
        description: 'Description of Event 3',
    },
    // Add more events as needed
];

// Function to generate HTML for announcements
function generateAnnouncementHTML(announcement) {
    return `
    <div class="ann-box" id="announcement-${announcement.id}">
        <span><i class='fas fa-user'></i> ${announcement.author}</span>
        <span><i class='fas fa-calendar'></i> ${announcement.date}</span>
        <h3>${announcement.title}</h3>
        <img style="display:none;" src="${announcement.imageUrl}" alt="${announcement.title}" />
        <div class="buttons">
            <button id="down-but" onclick="handleDownload('${announcement.imageUrl}')" class="download-btn"><i class="fas fa-download"></i> Download</button>
            <a id="view-but" href="${announcement.imageUrl}" target="_blank" rel="noopener noreferrer" class="view-btn"><i class="fas fa-external-link-alt"></i> View</a>
        </div>
        <p style="display:none;" class='p-desc'>${announcement.description}</p>
        <button onclick="toggleAnnouncement(${announcement.id})" class="toggle-btn">Read more...</button>
    </div>
    `;
}

// Function to generate HTML for events
function generateEventHTML(event) {
    return `
    <div class="event-box">
        <div class="event-date">
            <div class="date-box">
                <span class="date-month">${event.date.month}</span>
                <span class="date-day">${event.date.day}</span>
            </div>
        </div>
        <div class="event-details">
            <div class="event-det-box">
                <h3>${event.name}</h3>
                <p><i class='fas fa-clock'></i> ${event.time}</p>
            </div>
        </div>
    </div>
    `;
}

// Function to render announcements
function renderAnnouncements(page) {
    const announcementsContainer = document.getElementById('announcementsContainer');
    announcementsContainer.innerHTML = announcements
        .slice(page * 2, page * 2 + 2)
        .map(generateAnnouncementHTML)
        .join('');
    document.querySelector('.announcement-page').textContent = page + 1;
}

// Function to render events
function renderEvents(page) {
    const eventsContainer = document.getElementById('eventsContainer');
    eventsContainer.innerHTML = events
        .slice(page * 2, page * 2 + 2)
        .map(generateEventHTML)
        .join('');
    document.querySelector('.event-page').textContent = page + 1;
}

// Function to handle download
function handleDownload(imageUrl) {
    console.log('Downloading:', imageUrl);
}

// Function to toggle announcement
function toggleAnnouncement(id) {
    const announcement = document.getElementById(`announcement-${id}`);
    const button = announcement.querySelector('.toggle-btn');
    const description = announcement.querySelector('.p-desc');
    const img = announcement.querySelector('img');
    const view = document.getElementById('view-but');
    const down = document.getElementById('down-but');

    if (description.classList.contains('collapsed')) {
        description.classList.remove('collapsed');
        img.style.display = 'block';
        description.style.display = 'block';
        button.textContent = '...Read less';
    } else {
        description.classList.add('collapsed');
        img.style.display = 'none';
        description.style.display = 'none';
        button.textContent = 'Read more...';
    }
}

// Variables for pagination
let announcementPage = 0;
let eventPage = 0;

// Render initial data
renderAnnouncements(announcementPage);
renderEvents(eventPage);

// Event listeners for announcement pagination buttons
document.querySelector('.prev-btn-announcement').addEventListener('click', () => {
    announcementPage = Math.max(announcementPage - 1, 0);
    renderAnnouncements(announcementPage);
});

document.querySelector('.next-btn-announcement').addEventListener('click', () => {
    announcementPage = Math.min(announcementPage + 1, Math.ceil(announcements.length / 2) - 1);
    renderAnnouncements(announcementPage);
});

// Event listeners for event pagination buttons
document.querySelector('.prev-btn-event').addEventListener('click', () => {
    eventPage = Math.max(eventPage - 1, 0);
    renderEvents(eventPage);
});

document.querySelector('.next-btn-event').addEventListener('click', () => {
    eventPage = Math.min(eventPage + 1, Math.ceil(events.length / 2) - 1);
    renderEvents(eventPage);
});