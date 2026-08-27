<template>
  <div id="swagger-ui"></div>
</template>

<script setup>
import SwaggerUI from "swagger-ui-dist/swagger-ui-es-bundle.js";
import { defineProps, onMounted, onUnmounted } from "vue";

import "swagger-ui-dist/swagger-ui.css";

const props = defineProps(["specUrl"]);

let observer;

onMounted(() => {
  SwaggerUI({
    dom_id: "#swagger-ui",
    url: props.specUrl,
  });

  const html = document.documentElement;

  const updateSwaggerTheme = () => {
    html.classList.toggle("dark-mode", html.classList.contains("dark"));
  };

  updateSwaggerTheme();

  observer = new MutationObserver(updateSwaggerTheme);

  observer.observe(html, {
    attributes: true,
    attributeFilter: ["class"],
  });
});

onUnmounted(() => {
  observer?.disconnect();
});
</script>
