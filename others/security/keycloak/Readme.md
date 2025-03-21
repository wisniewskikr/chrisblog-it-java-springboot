Resource Server Grant Types:
* **Client Credential**: no users and roles. It requires only secret ID. Two steps: 1. Get token; 2. Get resource using token
* **Password Credential**: it requires user credentials and secret ID. Two steps: 1. Get token; 2. Get resource using token
* **Implicit**: it requires only user credentials. Two steps: 1. Get token; 2. Get resource using token
* **Authorization Code**: it requires user credentials and secret ID. Three steps: 1. Get authorization code; 2. Get token using authorization code; 3. Get resource using token
* **Authorization Code (With PKCE)**: it requires only user credentials. Three steps: 1. Get authorization code; 2. Get token using authorization code; 3. Get resource using token

**Token Relay** is the process of forwarding an authentication token from one service or application to another to maintain user authentication and authorization across multiple systems. It enables secure access delegation without exposing user credentials.

**Refresh Token** is a credential used to obtain a new access token without requiring the user to log in again.

TODO:
* Implement of MVC custom login page
* Implement of MVC custom logout page
* Implement SPA
* Implement Keycloak + Gateway API
