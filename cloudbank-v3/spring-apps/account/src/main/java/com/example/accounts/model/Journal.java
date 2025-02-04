// Copyright (c) 2023, Oracle and/or its affiliates. 
// Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl/ 

package com.example.accounts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "JOURNAL")
@Data
@NoArgsConstructor
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOURNAL_ID")
    private long journalId;

    // type is withdraw or deposit
    @Column(name = "JOURNAL_TYPE")
    private String journalType;

    @Column(name = "ACCOUNT_ID")
    private long accountId;

    @Column(name = "LRA_ID")
    private String lraId;

    @Column(name = "LRA_STATE")
    private String lraState;

    @Column(name = "JOURNAL_AMOUNT")
    private long journalAmount;

    public Journal(String journalType, long accountId, long journalAmount, String lraId, String lraState) {
        this.journalType = journalType;
        this.accountId = accountId;
        this.lraId = lraId;
        this.lraState = lraState;
        this.journalAmount = journalAmount;
    }

    public Journal(String journalType, long accountId, long journalAmount) {
        this.journalType = journalType;
        this.accountId = accountId;
        this.journalAmount = journalAmount;
    }
}