window.onload = function() {

  window.ui = SwaggerUIBundle({
    url: "../v1/eakte-api/src/main/resources/eakte-api-spec/eakte-api--main.yaml",
    dom_id: '#swagger-ui',
    deepLinking: true,
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
