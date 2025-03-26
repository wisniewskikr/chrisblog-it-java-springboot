FROM node:20.11.1-slim AS builder

WORKDIR /usr/src/app

COPY package.json package-lock.json ./

RUN npm install

COPY . .

RUN npm run build --omit=dev

FROM nginx:1.25.5-alpine

COPY --from=builder /usr/src/app/dist/angular-springboot-spa-security-keycloak-fe/browser /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]