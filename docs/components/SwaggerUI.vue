<template>
  <div id="swagger-ui"></div>
</template>

<script setup>
import SwaggerUI from "swagger-ui-dist/swagger-ui-es-bundle.js";
import { defineProps, onMounted } from "vue";

import "swagger-ui-dist/swagger-ui.css";

const props = defineProps(["specUrl"]);

onMounted(() => {
  SwaggerUI({
    dom_id: "#swagger-ui",
    url: props.specUrl,
  });
});
</script>
