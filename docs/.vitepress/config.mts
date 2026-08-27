import { defineConfig } from "vitepress";
import { withMermaid } from "vitepress-plugin-mermaid";

// https://vitepress.dev/reference/site-config
const vitepressConfig = defineConfig({
  base: "/eakte-schnittstelle/", // needs to be changed if delivered via sub path (e.g. "/docs/" for example.com/docs)
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
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: "Home", link: "/" },
      { text: "DMS", link: "/dms" },
      {
        text: "V1",
        items: [
          { text: "Index", link: "/v1/" },
          { text: "Swagger-UI", link: "/v1/swagger-ui" },
        ],
      },
      {
        text: "V2",
        items: [
          { text: "Index", link: "/v2/" },
          { text: "Swagger-UI", link: "/v2/swagger-ui" },
          { text: "arc42", link: "/v2/arc42/" },
        ],
      },
    ],
    sidebar: [
      {
        text: "DMS",
        link: "/dms",
      },
      {
        text: "V1",
        link: "/v1/",
        items: [
          { text: "Use Cases", link: "/v1/usecases" },
          { text: "Swagger-UI", link: "/v1/swagger-ui" },
        ],
      },
      {
        text: "V2",
        link: "/v2/",
        items: [
          { text: "Swagger-UI", link: "/v2/swagger-ui" },
          {
            text: "arc42",
            link: "/v2/arc42/",
            collapsed: false,
            items: [
              {
                text: "Introduction and Goals",
                link: "/v2/arc42/01_introduction_and_goals",
              },
              {
                text: "Architecture Constraints",
                link: "/v2/arc42/02_architecture_constraints",
              },
              {
                text: "Context and Scope",
                link: "/v2/arc42/03_context_and_scope",
              },
              {
                text: "Solution Strategy",
                link: "/v2/arc42/04_solution_strategy",
              },
              {
                text: "Building Block View",
                link: "/v2/arc42/05_building_block_view",
              },
              { text: "Runtime View", link: "/v2/arc42/06_runtime_view" },
              {
                text: "Deployment View",
                link: "/v2/arc42/07_deployment_view",
              },
              { text: "Cross-cutting Concepts", link: "/v2/arc42/08_concepts" },
              {
                text: "Architecture Decisions",
                link: "/v2/arc42/09_architecture_decisions",
              },
              {
                text: "Quality Requirements",
                link: "/v2/arc42/10_quality_requirements",
              },
              {
                text: "Risks and Technical Debts",
                link: "/v2/arc42/11_technical_risks",
              },
              { text: "Glossary", link: "/v2/arc42/12_glossary" },
            ],
          },
        ],
      },
    ],
    socialLinks: [
      {
        icon: "github",
        link: "https://github.com/it-at-m/eakte-schnittstelle",
      },
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
