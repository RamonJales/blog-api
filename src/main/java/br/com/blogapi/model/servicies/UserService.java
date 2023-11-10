package br.com.blogapi.model.servicies;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.blogapi.controllers.exceptions.ResourceNotFoundException;
import br.com.blogapi.data.vo.v1.ArticleVO;
import br.com.blogapi.mapper.Mapper;
import br.com.blogapi.model.entities.User;
import br.com.blogapi.model.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ArticleVO findById(Integer id) {

        User obj = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Object not found!"));

        return Mapper.parseObject(obj, ArticleVO.class);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("Username" + username+" not found!");
		}
	}

}
