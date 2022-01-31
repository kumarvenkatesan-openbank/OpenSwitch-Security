package money.bankopen.cards.issuance.securevault.utils;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(value = PersistenceListener.class)
public abstract class AbstractEntity{
	@Column(nullable = false)
	String createdBy;
	@Column(nullable = false)
	LocalDateTime createdAt;
	@Column(nullable = false)
	String modifiedBy;
	@Column(nullable = false)
	LocalDateTime modifiedAt;
}