# APIs

## Create user
- Method: POST
- Endpoint: `/customers/registers`
- Request:
  - Request body of
    - Full name
    - Email address
    - Phone number
- Response:
  - HTTP status code
## Retrieve tables for the given date (customer)
- Method: GET
- Endpoint: `/tables`
- Request:
  - Request (query) parameters
    - date: The date for which to check the availability
- Response:
  - HTTP status code
  - data: Page of table objects, each with the following properties:
    - id
    - name
    - maximum number of guests