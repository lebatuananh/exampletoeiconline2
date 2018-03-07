package vn.mra.core.service;

import vn.mra.core.dto.UserDTO;

public interface UserService {
    UserDTO isUserExist(UserDTO userDTO);
    UserDTO findRoleByUser(UserDTO userDTO);

}