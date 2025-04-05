-- 1. Create `press` table first
CREATE TABLE IF NOT EXISTS press (
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

-- 2. Create `user_finish` before using it in `user_print`
CREATE TABLE IF NOT EXISTS user_finish (
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

-- 3. Create `user_print` after `user_finish`
CREATE TABLE IF NOT EXISTS user_print (
    user_print_id BIGINT PRIMARY KEY AUTO_INCREMENT,
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
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_finish_id BIGINT,
    CONSTRAINT fk_user_finish_id FOREIGN KEY (user_finish_id) REFERENCES user_finish (finish_id)
);

-- 4. Create `press_finish`
CREATE TABLE IF NOT EXISTS press_finish (
    press_finish_id BIGINT PRIMARY KEY AUTO_INCREMENT,
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

-- 5. Create `press_print` after both `press` and `press_finish`
CREATE TABLE IF NOT EXISTS press_print (
    press_print_id BIGINT PRIMARY KEY AUTO_INCREMENT,
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
    press_finish_id BIGINT,
    press_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_press_finish_id FOREIGN KEY (press_finish_id) REFERENCES press_finish (press_finish_id),
    CONSTRAINT fk_press_id FOREIGN KEY (press_id) REFERENCES press (press_id)
);
