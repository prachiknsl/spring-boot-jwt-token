# spring-boot-jwt-token
1. You should have MySQL server running on your local and can configure credentials in application.properties.
2. Run Application on local
3. Register user using POST: localhost:8080/register
with body :
{
    "username": "user",
    "password": "user",
    "role" : "ROLE_USER/ROLE_ADMIN"
}
5. Generate token using POST: localhost:8080/authenticate
with body : 
{
    "username" :"user",
    "password": "user"
}
7. Use this generated token to access user/admin API as per role.
   1. User with ROLE_ADMIN role can access both GET: localhost:8080/user and GET: localhost:8080/user
   2. User with ROLE_USER role can access GET: localhost:8080/user only.
