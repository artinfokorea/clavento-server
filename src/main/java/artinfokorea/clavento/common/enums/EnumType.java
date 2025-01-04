package artinfokorea.clavento.common.enums;

public interface EnumType {
	String getName();

	String getDescription(LanguageType lang);

	default String getDescription() {
		return getDescription(LanguageType.KO);
	}
}
