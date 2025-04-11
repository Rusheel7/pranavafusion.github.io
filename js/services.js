$(document).ready(function () {
    // Initialize GSAP ScrollTrigger
    gsap.registerPlugin(ScrollTrigger);

    // Trigger animations for each step
    $(".step").each(function () {
        gsap.fromTo(
            $(this),
            { opacity: 0, y: 100 }, // Initial state (invisible and below)
            {
                opacity: 1,
                y: 0, // Animated state (visible and in place)
                scrollTrigger: {
                    trigger: $(this),
                    start: "top 80%", // Start animation when step reaches 80% from top
                    end: "bottom 40%", // End when step is near the bottom
                    toggleActions: "play none none reverse", // Play animation on scroll
                },
            }
        );
    });
});
