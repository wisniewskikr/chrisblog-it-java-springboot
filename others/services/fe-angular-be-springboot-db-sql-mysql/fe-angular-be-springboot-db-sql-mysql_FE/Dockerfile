# Stage 1: Build the Angular application
FROM node:18-alpine AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the package.json and package-lock.json to install dependencies
COPY package*.json ./

# Install the Angular CLI globally
RUN npm install -g @angular/cli

# Install the dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Build the Angular application in docker mode
RUN ng build --configuration=production

# Stage 2: Serve the application using Nginx
FROM nginx:alpine

# Copy the built files from the previous stage to the Nginx HTML directory
COPY --from=build /app/dist/fe-angular-be-springboot-db-sql-mysql_fe/browser /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx server
CMD ["nginx", "-g", "daemon off;"]