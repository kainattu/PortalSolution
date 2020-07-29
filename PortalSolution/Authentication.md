Register Service-
Method- Post
Url- localhost:8080/register
Response body -
Multiple role user-   {"username" :"multi","password":"password", "roles":["Admin","User"], "email":"multi@test.com", "mobileNo":9333244554}
Admin role user- {"username" :"admin","password":"password", "roles":["Admin"], "email":"admin@test.com", "mobileNo":9333538292}
User role user- {"username" :"user","password":"password", "roles":["User"], "email":"user@test.com", "mobileNo":8478291234}


Login Serivce
Method Post
Url localhost:8080/authenticate
Request body 
{"username" :"multi","password":"password"}
Response body 
{
    "tokenExpiry": 18000,
    "username": "multi",
    "email": null,
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtdWx0aSIsImV4cCI6MTU5NTk0MzcxMCwiaWF0IjoxNTk1OTI1NzEwfQ.d1XO4E5b_R712TFniM9iEYnG_5JDRUQ6catF0jqJM9unZ25gH9JdziGlkJvRBsF-jQ5Ey7Pb1PiUwjW4RvfBnA"
}


For accessing other api send token from authenticate response and send in header as authorization
Authorization  Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtdWx0aSIsImV4cCI6MTU5NTkzNzk3NSwiaWF0IjoxNTk1OTE5OTc1fQ.N3I61tbrSieeqTbCRO0Iwl8Gh80pboNM0H5wc9lP68ikPBcJqST5e7fL9zqtFunS8Do6WaDiAF9OOzqy_hNIZA

For multi user all url are accesisble
url localhost:8080/user/getUser?username=multi
url localhost:8080/hello
url localhost:8080/admin/getAllUser


For admin user accesisble urls are
url localhost:8080/hello
url localhost:8080/admin/getAllUser

For user user accesisble urls are
url localhost:8080/user/getUser?username=user
url localhost:8080/hello
