// ================= GSAP + ScrollTrigger =================
document.addEventListener("DOMContentLoaded", () => {
  gsap.registerPlugin(ScrollTrigger);

  // 1) Animación hero: imagen “flotante” con leve movimiento continuo
  gsap.to(".planet-float", {
    y: 20,
    repeat: -1,
    yoyo: true,
    ease: "sine.inOut",
    duration: 3
  });

  // 2) Fade-in de texto e imagen en hero
  gsap.from(".hero-title", {
    opacity: 0,
    y: 50,
    duration: 1,
    ease: "power2.out",
    delay: 0.3
  });
  gsap.from(".hero-subtitle", {
    opacity: 0,
    y: 30,
    duration: 1,
    ease: "power2.out",
    delay: 0.6
  });
  gsap.from(".hero-btn", {
    opacity: 0,
    y: 30,
    duration: 1,
    ease: "power2.out",
    delay: 0.9
  });

  // 3) Fade-in de feature-cards al scrollear
  gsap.utils.toArray(".feature-card").forEach((card) => {
    gsap.from(card, {
      opacity: 0,
      y: 50,
      duration: 0.8,
      ease: "power3.out",
      scrollTrigger: {
        trigger: card,
        start: "top 85%",
        toggleActions: "play none none reverse"
      }
    });
  });

  // 4) Fade-in del vídeo al scrollear
  gsap.from(".video-wrapper", {
    opacity: 0,
    y: 50,
    duration: 1,
    ease: "power3.out",
    scrollTrigger: {
      trigger: ".video-wrapper",
      start: "top 85%",
      toggleActions: "play none none reverse"
    }
  });

  // 5) Fade-in de planet-cards al scrollear
  gsap.utils.toArray(".planet-card").forEach((card, i) => {
    gsap.from(card, {
      opacity: 0,
      y: 50,
      duration: 0.8,
      ease: "power3.out",
      delay: i * 0.1,
      scrollTrigger: {
        trigger: card,
        start: "top 90%",
        toggleActions: "play none none reverse"
      }
    });
  });

  // 6) Header: cambiar fondo si hacemos scroll
  const header = document.querySelector(".header");
  window.addEventListener("scroll", () => {
    if (window.scrollY > 50) {
      header.classList.add("scrolled");
    } else {
      header.classList.remove("scrolled");
    }
  });
});