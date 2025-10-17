window.initSwiper = (selector) => {
  const swiper = new Swiper(selector, {
    // Enable looping
    loop: true,

    // --- ADD THIS BLOCK FOR AUTOPLAY ---
    autoplay: {
      delay: 3000, // 3000 milliseconds = 3 seconds
      disableOnInteraction: false, // Optional: resumes autoplay after user interacts
    },
    // --- END OF NEW BLOCK ---

    // Add pagination dots (the little circles at the bottom)
    pagination: {
      el: '.swiper-pagination',
      clickable: true,
    },

    // Add navigation arrows (the < > buttons)
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });
};