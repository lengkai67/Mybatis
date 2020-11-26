package com.lengkai.dao;

import com.lengkai.domain.Account;
import com.lengkai.domain.AccountUser;

import java.util.List;

public interface AccountDao {

    List<AccountUser>  findall();
}
