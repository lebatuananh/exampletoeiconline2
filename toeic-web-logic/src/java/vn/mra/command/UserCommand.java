package vn.mra.command;

import vn.mra.core.dto.UserDTO;
import vn.mra.core.web.command.AbstractCommand;

public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand(){
        this.pojo=new UserDTO();
    }
}