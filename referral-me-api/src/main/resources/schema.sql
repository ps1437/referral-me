CREATE TABLE Users (
    id UUID PRIMARY KEY,
    google_id VARCHAR(255),
    name VARCHAR(255),
    email VARCHAR(255),
    role ENUM ('Admin', 'Referrer', 'User'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Jobs (
    id UUID PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    posted_by UUID,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    company_id UUID,
    FOREIGN KEY (posted_by) REFERENCES Users(id),
    FOREIGN KEY (company_id) REFERENCES Companies(id)
);

CREATE TABLE Referrals (
    id UUID PRIMARY KEY,
    referrer_id UUID,
    applicant_id UUID,
    job_id UUID,
    status ENUM ('Pending', 'Contacted', 'Referred', 'Closed'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (referrer_id) REFERENCES Users(id),
    FOREIGN KEY (applicant_id) REFERENCES Users(id),
    FOREIGN KEY (job_id) REFERENCES Jobs(id)
);

CREATE TABLE Companies (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    website VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Applications (
    id UUID PRIMARY KEY,
    job_id UUID,
    applicant_id UUID,
    status ENUM ('Pending', 'Contacted', 'Referred', 'Closed'),
    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (job_id) REFERENCES Jobs(id),
    FOREIGN KEY (applicant_id) REFERENCES Users(id)
);
