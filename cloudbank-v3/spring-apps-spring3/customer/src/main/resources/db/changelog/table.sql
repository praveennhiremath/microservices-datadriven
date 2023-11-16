-- liquibase formatted sql

--changeset gotsysdbax:1
--preconditions onFail:MARK_RAN onerror:MARK_RAN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM CUSTOMER.CUSTOMERS WHERE 1=2
DROP TABLE CUSTOMER.CUSTOMERS;

--changeset gotsysdbax:2
CREATE TABLE CUSTOMER.CUSTOMERS (
    CUSTOMER_ID VARCHAR2 (20),
    CUSTOMER_NAME VARCHAR2 (40),
    CUSTOMER_EMAIL VARCHAR2 (40),
    DATE_BECAME_CUSTOMER DATE DEFAULT SYSDATE NOT NULL,
    CUSTOMER_OTHER_DETAILS VARCHAR2 (4000),
    PASSWORD VARCHAR2(40),
    ROLE VARCHAR2(40)
) LOGGING;

ALTER TABLE CUSTOMER.CUSTOMERS ADD CONSTRAINT CUSTOMERS_PK PRIMARY KEY (CUSTOMER_ID) USING INDEX LOGGING;
COMMENT ON TABLE CUSTOMER.CUSTOMERS IS 'CLOUDBANK CUSTOMERS TABLE';

--rollback DROP TABLE CUSTOMER.CUSTOMERS;
