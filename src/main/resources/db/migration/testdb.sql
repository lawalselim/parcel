-- ${flyway:timestamp}

DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS category_product;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS vendors;
DROP TABLE IF EXISTS user_address;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;

CREATE TABLE address (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         country VARCHAR(255),
                         city VARCHAR(255),
                         district VARCHAR(255),
                         apartmentNumber INT,
                         street VARCHAR(255),
                         user_id INT,
                         CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB;



CREATE TABLE category (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          categoryName VARCHAR(255)
    -- Add any other columns as needed
) ENGINE=InnoDB;

CREATE TABLE orders (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        orderNumber BIGINT,
                        productName VARCHAR(255),
                        productBrand VARCHAR(255),
                        productDescription VARCHAR(255),
                        productPrice VARCHAR(255),
                        productImageUrl VARCHAR(255),
                        address_id INT,
                        vendor_id INT,
                        user_id INT,
                        CONSTRAINT FK_address_id FOREIGN KEY (address_id) REFERENCES address(id),
                        CONSTRAINT FK_vendor_id FOREIGN KEY (vendor_id) REFERENCES vendors(id),
                        CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB;

CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          productName VARCHAR(255),
                          productBrand VARCHAR(255),
                          productDescription VARCHAR(255),
                          productPrice DOUBLE,
                          productImageUrl VARCHAR(255),
                          stock INT,
                          category_id INT,
                          vendor_id INT,
                          favoriteNumber INT,
                          CONSTRAINT FK_category_id FOREIGN KEY (category_id) REFERENCES category(id),
                          CONSTRAINT FK_vendor_id FOREIGN KEY (vendor_id) REFERENCES vendors(id)
) ENGINE=InnoDB;

CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       userName VARCHAR(255) NOT NULL,
                       firstName VARCHAR(255) NOT NULL,
                       lastName VARCHAR(255) NOT NULL,
                       email VARCHAR(255),
                       phoneNumber VARCHAR(255) NOT NULL,
                       createDate DATE,
                       notificationPermission BOOLEAN,
                       password VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE vendors (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         fullName VARCHAR(255) NOT NULL,
                         profilePictureUrl VARCHAR(255),
                         email VARCHAR(255)
) ENGINE=InnoDB;
CREATE TABLE cart (
                      id INT PRIMARY KEY,
                      quantity INT,
                      productName VARCHAR(255),
                      productBrand VARCHAR(255),
                      productDetails VARCHAR(255),
                      productPrice DOUBLE,
                      productImageUrl VARCHAR(255),
                      user_id INT,
                      CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB;


-- Dummy data for 'address' table
INSERT INTO address (country, city, district, apartmentNumber, street)
VALUES ('Country1', 'City1', 'District1', 123, 'Street1');

-- Dummy data for 'category' table
INSERT INTO category (categoryName) VALUES ('Category1');

-- Dummy data for 'orders' table
INSERT INTO orders (id, orderNumber, productName, productBrand, productDescription, productPrice, productImageUrl, address_id, vendor_id, user_id)
VALUES (1, 123456789, 'Product1', 'Brand1', 'Description1', 19.99, 'image1.jpg', 1, 1, 1);

-- Dummy data for 'products' table
INSERT INTO products (id, productName, productBrand, productDescription, productPrice, productImageUrl, stock, category_id, vendor_id, favoriteNumber)
VALUES (1, 'Product1', 'Brand1', 'Description1', 19.99, 'image1.jpg', 50, 1, 1, 10);

-- Dummy data for 'users' table
INSERT INTO users (id, userName, firstName, lastName, email, phoneNumber, createDate, notificationPermission,password)
VALUES (1, 'username1', 'First1', 'Last1', 'user1@example.com', '123456789', CURRENT_TIMESTAMP, true, 'password1');

-- Dummy data for 'vendors' table
INSERT INTO vendors (id, fullName, profilePictureUrl, email)
VALUES (1, 'Vendor1', 'profile1.jpg', 'vendor1@example.com');

-- Dummy data for 'cart' table
INSERT INTO cart (id,quantity, productName, productBrand, productDetails, productPrice, productImageUrl, user_id)
VALUES (1, 2, 'Product1', 'Brand1', 'Details1', 19.99, 'image1.jpg', 1);

