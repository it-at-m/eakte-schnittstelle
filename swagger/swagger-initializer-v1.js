window.onload = function() {

  window.ui = SwaggerUIBundle({
    // multi-part OpenAPI specification might be rendered incomplete:
    //url: "../v1/eakte-api/src/main/resources/eakte-api-spec/eakte-api--main.yaml",
    url: "../v1/eakte-api-v1-spec-single-file/target/classes/eakte-rest-api-v1-spec-single-file.yaml",
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
