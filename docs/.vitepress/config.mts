import { defineConfig } from "vitepress";
import { withMermaid } from "vitepress-plugin-mermaid";

// https://vitepress.dev/reference/site-config
const vitepressConfig = defineConfig({
  base: "/", // needs to be changed if delivered via sub path (e.g. "/docs/" for example.com/docs)
  title: "E-Akte SST Doku",
  description: "Dokumentation der E-Akte Schnittstelle",
  head: [
    [
      "link",
      {
        rel: "icon",
        href: `https://assets.muenchen.de/logos/lhm/icon-lhm-muenchen-32.png`,
      },
    ],
  ],
  lastUpdated: true,
  appearance: false,
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: "Home", link: "/" },
      {
        text: "V1",
        items: [
          { text: "Index", link: "/v1" },
          { text: "Swagger-UI", link: "/v1/swagger-ui" },
        ],
      },
      {
        text: "V2",
        items: [
          { text: "Index", link: "/v2" },
          { text: "Swagger-UI", link: "/v2/swagger-ui" },
        ],
      },
    ],
    sidebar: [
      {
        text: "V1",
        link: "/v1",
        items: [
          { text: "Use Cases", link: "/v1/usecases" },
          { text: "Swagger-UI", link: "/v1/swagger-ui" },
        ],
      },
      {
        text: "V2",
        link: "/v2",
        items: [
          { text: "Swagger-UI", link: "/v2/swagger-ui" },
        ],
      },
    ],
    socialLinks: [
      { icon: "github", link: "https://github.com/it-at-m/eakte-schnittstelle" },
    ],
    editLink: {
      pattern:
        "https://github.com/it-at-m/eakte-schnittstelle/blob/main/docs/:path",
      text: "View this page on GitHub",
    },
    footer: {
      message: `<a href="https://opensource.muenchen.de/impress.html">Impress and Contact</a>`,
    },
    outline: {
      level: "deep",
    },
    search: {
      provider: "local",
    },
  },
  markdown: {
    image: {
      lazyLoading: true,
    },
  },
});

export default withMermaid(vitepressConfig);
