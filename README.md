# FileUploadAPI
RESTful api allow file searching and upload

FIle saved as metadata to in-memory database on format with name, size, path and file ID

Access from /files URL by POST method could upload file.

GET method via /files URL returns all files in database in JSON format.

GET method via /files/{id} URL return file with id in JSON format.
