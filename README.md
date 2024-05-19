# Referral Portal 

## Table of Contents
1. [Introduction](#introduction)
2. [Objectives](#objectives)
3. [User Roles and Permissions](#user-roles-and-permissions)
4. [Functional Requirements](#functional-requirements)
5. [Data Model](#data-model)
6. [API Endpoints](#api-endpoints)

## Introduction
The purpose of this document is to outline the design and specifications for a referral portal. The portal will enable users to:

- Register as both job seekers and referrers.
- Job seekers can request referrals based on job links or job IDs.
- Referrers can refer any person based on their profile and resume.
- Users can post job information on the portal.
- Referrals can look for the candidate profile how are looking for job change 

The system will track referrals and reward successful referrals to ensure a user-friendly and efficient experience.


## Objectives
- Enable users to find and refer new candidates easily.
- Allow users to request referrals for specific jobs.
- Track the status of each referral and referral request.
- Allow users to post job information


## User Roles and Permissions
### Admin
- Manage users and roles.
- View and manage all referrals.
- ~~Configure rewards and referral settings.~~


## Functional Requirements
### User Registration and Authentication
- Users can register and log in ( Google based auth).

### Referral Submission

### Referral Tracking



## User Interface Design
### Home Page
- Welcome message.
- Quick links to submit a applciation for referral and view referral status.

### Job Referral Form
- Fields: Name, Email, Phone Number, Message , JobLink Or Job Code ,Resume and current location.
- Submit button.

### Referral Status Page
- List of all applied application and referal status ( open,Closed ,Inprogress).

### Admin Dashboard
- Overview of all referrals details.
- No of people they referred
- No of applicant, application in progress, active Referral

### Wireframes


## Data Model
### Users Table
- `id`: UUID (Primary Key)
- `google_id`: String (Google authentication ID)
- `name`: String
- `email`: String
- `role`: Enum (Admin, Referrer, User)
- `created_at`: Timestamp
- `updated_at`: Timestamp

### Jobs Table
- `id`: UUID (Primary Key)
- `title`: String
- `description`: Text
- `posted_by`: UUID (references Users.id)
- `created_at`: Timestamp
- `updated_at`: Timestamp
- `company_id`: UUID (references Companies.id)

### Referrals Table
- `id`: UUID (Primary Key)
- `referrer_id`: UUID (references Users.id where role is Referrer)
- `applicant_id`: UUID (references Users.id where role is User)
- `job_id`: UUID (references Jobs.id)
- `status`: Enum (Pending, Contacted, Referred, Closed)
- `created_at`: Timestamp
- `updated_at`: Timestamp

### Companies Table
- `id`: UUID (Primary Key)
- `name`: String
- `address`: String
- `website`: String
- `created_at`: Timestamp
- `updated_at`: Timestamp

### Applications Table
- `id`: UUID (Primary Key)
- `job_id`: UUID (references Jobs.id)
- `applicant_id`: UUID (references Users.id where role is User)
- `status`: Enum (Submitted, In Review, Interview Scheduled, Rejected, Hired)
- `applied_at`: Timestamp
- `updated_at`: Timestamp



## API Endpoints
### User Authentication
- `POST /api/auth/login`: Endpoint for Google authentication. Expects a Google ID token in the request body and returns a JWT token upon successful authentication.

### Job Operations
- `GET /api/jobs`: Retrieves a list of all available jobs.
- `GET /api/jobs/:id`: Retrieves details of a specific job by ID.
- `POST /api/jobs/:id/request-referral`: Allows users to request a referral for a specific job. Expects referral details in the request body (e.g., applicant ID, job ID).
- `POST /api/jobs`: Creates a new job (Admin only).
- `PUT /api/jobs/:id`: Updates an existing job (references Users.id).
 `DELETE /api/admin/jobs/:id`: Deletes a job (Admin Or  references Users.id).

### Referral Operations
- `GET /api/referrals`: Retrieves a list of all referrals made by the user.
- `GET /api/referrals/:id`: Retrieves details of a specific referral by ID.

### User Profile
- `GET /api/users/me`: Retrieves the profile of the authenticated user.


