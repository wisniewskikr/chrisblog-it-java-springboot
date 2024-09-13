# Stage 1: Build React app
FROM node:18-alpine AS build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Build the React app
RUN npm run build

# Stage 2: Set up the Express server
FROM node:18-alpine

# Set the working directory
WORKDIR /app

# Copy the built React app from the previous stage
COPY --from=build /app/build ./build

# Copy package.json and package-lock.json
COPY package*.json ./

# Install production dependencies
RUN npm install --only=production

# Copy server.js
COPY server.js .

# Expose the desired port
EXPOSE 3000

# Start the Express server
CMD ["node", "server.js"]