Types:
- Mvc
- Single Page Application (SPA)
- Api

Types:
- client: many properties
- server: only one property

Grant Type:
- Authorization Code
- Client Credentials

Code Flows:
- Authorization Code Flow (oAuth Client)
- PKCE Authorization Code Flow (SinglePage or Mobile) (oAuth Server, JOSE, Spring Security)
- Client Credentials (Spring Security, oAuth Server Resource)

JOSE - Javascript Object Signing and Encryption (Frameworks):
- JWT: Json Web Tokens
- JWS: Json Web Signature
- JWE: Json Web Encryption
- JWK: Json Web Key

---

Application types:
- HTML
	- Basic
	- Form (Default)
	- Form (Custom)
	- 2 Factor Authentication
	- SSO
		- SAML
		- OIDC + OAUTH2
			- Keycloack
			- GitHub
			- Facebook
			- Google
			- etc.
- API
	- Basic (don't recommended - credentials sent every time)
	- Certificate x509
	- Authorization Manual + Authentication OAuth2
		- API Key + OAuth2
		- JSON + OAuth2

OAuth2 types:
- Implicit Grant
- Resource Owner Password Credentials
- Client Credentials

---

java-springboot-security-html-nosso-basic-springsecurity
java-springboot-security-html-nosso-formdefault-springsecurity
java-springboot-security-html-nosso-formcustom-springsecurity
java-springboot-security-html-sso-saml-okta
java-springboot-security-html-sso-oidcoauth2-keykloack
java-springboot-security-html-sso-oidcoauth2-facebook
java-springboot-security-html-sso-oidcoauth2-google
java-springboot-security-html-sso-oidcoauth2-github
java-springboot-security-html-springsecurity-customform-userdetailsservice
java-springboot-security-html-springsecurity-customform-authenticationprovider
java-springboot-security-html-springsecurity-customform-securitycontextholder


java-springboot-security-api-nooauth2-basic-springsecurity
java-springboot-security-api-nooauth2-apikey-springsecurity
java-springboot-security-api-nooauth2-json-springsecurity
java-springboot-security-api-withoauth2-basic-oauth2
java-springboot-security-api-withoauth2-apikey-oauth2
java-springboot-security-api-withoauth2-json-oauth2
java-springboot-security-api-springsecurity-basic-userdetailsservice
java-springboot-security-api-springsecurity-basic-authenticationprovider
java-springboot-security-api-springsecurity-json-securitycontextholder

---


api-springsec-onereq-source-header-basic-authn-filter-securitycontextholder-authr-config
api-springsec-onereq-source-header-apikey-authn-filter-securitycontextholder-authr-config
api-springsec-onereq-source-header-jwtbearer-authn-filter-securitycontextholder-authr-config
api-springsec-onereq-source-body-json-authn-filter-securitycontextholder-authr-config
api-springsec-onereq-source-url-params-authn-filter-securitycontextholder-authr-config
api-springsec-tworeq-source-header-basic-then-oauth2
api-springsec-tworeq-source-header-apikey-then-oauth2
api-springsec-tworeq-source-body-json-then-oauth2
api-springsec-tworeq-source-url-params-then-oauth2

api-springsec-onereq-source-header-basic-authn-inmemory-authr-config
api-springsec-onereq-source-header-basic-authn-userdetailsservice-authr-config
api-springsec-onereq-source-header-basic-authn-authenticationprovider-authr-config

html-springsec-source-header-basic-authn-inmemory-authr-config
html-springsec-source-body-form-default-authn-inmemory-authr-config
html-springsec-source-body-form-custom-authn-inmemory-authr-config
html-springsec-source-body-params-authn-filter-securitycontextholder-authr-config
html-springsec-source-url-params-authn-filter-securitycontextholder-authr-config
html-springsec-sso-authn-saml-okta-authr-config
html-springsec-sso-authn-oidcoauth2-okta-authr-config (logout doesn't work)
html-springsec-sso-authn-oidcoauth2-keycloak-authr-config
html-springsec-sso-authn-oidcoauth2-facebook-authr-config (doesn't work)
html-springsec-sso-authn-oidcoauth2-google-authr-config (logout doesn't work)
html-springsec-sso-authn-oidcoauth2-github-authr-config (logout doesn't work)

html-springsec-source-body-form-custom-authn-userdetailsservice-authr-config
html-springsec-source-body-form-custom-authn-authenticationprovider-authr-config

---

OIDC Workflow
https://www.youtube.com/watch?v=7gWcPWh5WVY&list=PLab_if3UBk99jYV1jfe_7fKQczVX9H4zZ&index=5

Request:
- type: type of authorization
- client_id:
- redirect_id:
- scope: action to perform
- state: unique id of request - only one

Response:
- code
- state

Steps:
1. User via browser sends request to Application with action
1. Application sends back response to browser with information above
1. Browser sends request to Authentication Servier for form with information above
1. Authentication Servier sends back to User via browser form
1. User via browser fills credentials
1. User via broser sends form to Authorization Server
1. Authorization Server sends back response to browser with code and state
1. Browser sends request to Application with code and state
1. Application sends request to Authentication Server with code and state for token
1. Authentication Server sends back response to Application the token
1. Application sends request to Data Base for user info
1. Data Base sends back response to Application with user info
1. Aplication sends back response to User via browser with user info

Security:
	- Client Authentication + Client Authorization
		- SSO
			- SAML
			- OIDC + OAuth2
		- NO-SSO
			- OAuth2
				- Token inside Client
					- Hardcoded
					- Autogenerated
				- Token outside Client			
					- Authentication
					- Outsourced Authentication - OIDC
			- No-OAuth2
	- Server Authentication - SSL
	- Client Authorization - OAuth2
		- JWT (JSON Web Token) (Header + Payload + Signature)
		- etc.
