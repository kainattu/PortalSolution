Register Service-
Method- Post
Url- localhost:8080/register
Response body -
Multiple role user-   {"username" :"multirole","password":"password", "roles":["Admin","User"], "email":"multirole@test.com", "mobileNo":9333244554}
Admin role user- {"username" :"admin","password":"password", "roles":["Admin"], "email":"admin@test.com", "mobileNo":9333538292}
User role user- {"username" :"user","password":"password", "roles":["User"], "email":"user@test.com", "mobileNo":8478291234}


Login Serivce
Method Post
Url localhost:8080/authenticate
Request body 
{"username" :"multirole","password":"password"}
Response body 
{
    "tokenExpiry": 18000,
    "username": "multi",
    "email": null,
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtdWx0aSIsImV4cCI6MTU5NTk0MzcxMCwiaWF0IjoxNTk1OTI1NzEwfQ.d1XO4E5b_R712TFniM9iEYnG_5JDRUQ6catF0jqJM9unZ25gH9JdziGlkJvRBsF-jQ5Ey7Pb1PiUwjW4RvfBnA"
}


curl http://localhost:8080/user/getUser?username=multi
   -H "Accept: application/json"
   -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtdWx0aSIsImV4cCI6MTcwNzI1ODIwNiwiaWF0IjoxNzA3MjQwMjA2fQ.YorWTKY8f5OGgAw_1EjngVzsOHFS9u184MHWYWKFAqS-KJEyamJ7qhWw-EQBxnsQh6m-CtscpIhQpgo4nqnLTA"
   
For accessing other api send token from authenticate response and send in header as authorization
Authorization  Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtdWx0aSIsImV4cCI6MTcwNzI1NzAwMCwiaWF0IjoxNzA3MjM5MDAwfQ.2NsjE8OqH4iyKeCEbhA5w97zwsqGCcDBpdM8aqtsGE1ozWF2tiFRewQ6HdPcW3WzYgljzFRNNViVjiGXW-wpeA

For multi user all url are accesisble
url localhost:8080/user/getUser?username=multirole
url localhost:8080/hello
url localhost:8080/admin/getAllUser


For admin user accesisble urls are
url localhost:8080/hello
url localhost:8080/admin/getAllUser

For user user accesisble urls are
url localhost:8080/user/getUser?username=user
url localhost:8080/hello


# file upload functionality .

http://localhost:8080/api/files/single
http://localhost:8080/api/files/all 
