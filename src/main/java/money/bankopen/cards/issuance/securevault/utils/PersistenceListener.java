package money.bankopen.cards.issuance.securevault.utils;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;


public class PersistenceListener {
	@PrePersist
	void onPreCreate(Object entity) {
		AbstractEntity baseEntity = (AbstractEntity) entity;
		baseEntity.setCreatedAt(LocalDateTime.now());
		baseEntity.setModifiedAt(LocalDateTime.now());
		var createdBy = "SYSTEM";
		if(StringUtils.isEmpty(baseEntity.getCreatedBy())) {
			baseEntity.setCreatedBy(createdBy);
		}
		if(StringUtils.isEmpty(baseEntity.getModifiedBy())) {
			baseEntity.setModifiedBy(createdBy);
		}	
	}

	@PreUpdate
	void onPreUpdate(Object entity) {
		AbstractEntity baseEntity = (AbstractEntity) entity;
		baseEntity.setModifiedAt(LocalDateTime.now());
		var changedBy = "SYSTEM";
		if(StringUtils.isEmpty(baseEntity.getModifiedBy())) {
			baseEntity.setModifiedBy(changedBy);
		}
	}
}
