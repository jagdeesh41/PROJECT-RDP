CREATE TABLE IF NOT EXISTS press_ledger (
    press_id INT PRIMARY KEY AUTO_INCREMENT,
    press_name VARCHAR(255) NOT NULL,
    contact_person_name VARCHAR(255),
    phone_number VARCHAR(255),
    last_payment_date TIMESTAMP,
    last_paid_amount DECIMAL(10, 2),
    outstanding_amount DECIMAL(10, 2),
    total_prints INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS finish_details (
    finish_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cutting VARCHAR(255),
    cutting_amount DECIMAL(10, 2),
    digital_dye_cutting VARCHAR(255),
    dye_cutting_sheets INT,
    dye_cutting_amount DECIMAL(10, 2),
    lamination_type VARCHAR(255),
    lamination_sheets INT,
    lamination_amount DECIMAL(10, 2),
    total_sheets INT,
    total_amount DECIMAL(10, 2),
    side VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the print_details table
CREATE TABLE IF NOT EXISTS print_details (
    print_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(255),
    print_details VARCHAR(255),
    media_type VARCHAR(255),
    size VARCHAR(255),
    quantity VARCHAR(255),
    sides VARCHAR(255),
    number_of_prints VARCHAR(255),
    color VARCHAR(255),
    amount VARCHAR(255),
    payment_mode VARCHAR(255),
    advance VARCHAR(255),
    wastage_print VARCHAR(255),
    payment_status VARCHAR(255),

    -- Foreign key for Finish (One-to-One)
    finish_id BIGINT,

    -- Foreign key for Press (Many-to-One)
    press_id INT,  -- Ensure this is INT for compatibility with press_ledger

    -- Timestamps for audit
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    -- Set up foreign key relationships
    CONSTRAINT fk_finish_id FOREIGN KEY (finish_id) REFERENCES finish_details (finish_id),
    CONSTRAINT fk_press_id FOREIGN KEY (press_id) REFERENCES press_ledger (press_id)
);
