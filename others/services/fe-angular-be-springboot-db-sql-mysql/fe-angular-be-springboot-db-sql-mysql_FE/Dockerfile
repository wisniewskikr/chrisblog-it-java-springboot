FROM node:20.11.1-slim AS builder

WORKDIR /usr/src/app

COPY package.json package-lock.json ./

RUN npm install

COPY . .

RUN npm run build --omit=dev



# # Stage 2: Serve app with nginx server

FROM nginx:1.25.4-perl

COPY --from=builder /usr/src/app/dist/fe-angular-be-springboot-db-sql-mysql_fe/browser /usr/share/nginx/html

EXPOSE 80