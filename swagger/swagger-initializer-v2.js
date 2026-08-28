window.onload = function() {

  window.ui = SwaggerUIBundle({
    url: "../v2/eakte-api-v2/eakte-api-v2-spec-single-file/target/classes/eakte-rest-api-v2-spec-single-file.yaml",
    dom_id: '#swagger-ui',
    deepLinking: true,
    defaultModelsExpandDepth: 1,
    presets: [
      SwaggerUIBundle.presets.apis,
      SwaggerUIStandalonePreset
    ],
    plugins: [
      SwaggerUIBundle.plugins.DownloadUrl
    ],
    layout: "StandaloneLayout"
  });

};
