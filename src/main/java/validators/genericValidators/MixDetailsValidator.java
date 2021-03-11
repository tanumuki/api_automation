package validators.genericValidators;


import entities.MixDetails;
import entities.ModuleWithViewMoreArray;
import org.testng.asserts.SoftAssert;

public class MixDetailsValidator extends PlaylistValidator {
    final String className = getClass().getName();

    public void validate(MixDetails md, SoftAssert sa) {
        super.validate(md, sa);
        validateModules(md, sa);
    }

    public void validateModules(MixDetails md, SoftAssert sa) {
        ModuleWithViewMoreArray mod = md.getModules().getList();
        new ModulesDataValidator().validate(mod, sa);
    }
}
