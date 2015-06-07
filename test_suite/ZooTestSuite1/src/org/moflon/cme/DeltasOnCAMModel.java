package org.moflon.cme;

import org.eclipse.emf.ecore.EObject;
import org.moflon.core.utilities.eMoflonEMFUtil;

import CAMLanguage.Argument;
import CAMLanguage.CAMLanguageFactory;
import CAMLanguage.CAMModel;
import CAMLanguage.GOTO;
import CAMLanguage.TOOLPATH;

public class DeltasOnCAMModel
{

   public static void swapChosenTool(EObject root)
   {
      CAMModel model = (CAMModel) root;
      TOOLPATH toolPath = (TOOLPATH) model.getOperations().get(0);
      
      eMoflonEMFUtil.remove(toolPath.getChosenTool());
      
      Argument newTool = CAMLanguageFactory.eINSTANCE.createArgument();
      newTool.setOperation(toolPath);
      newTool.setValue("F_D42");
      toolPath.setChosenTool(newTool);
   }
   
   public static void swapXArgOfFirstOperation(EObject root)
   {
      CAMModel model = (CAMModel) root;
      GOTO rgoto = (GOTO) model.getOperations().get(1);

      Argument oldArg = rgoto.getXCoordinate();
      eMoflonEMFUtil.remove(oldArg);

      Argument newArg = CAMLanguageFactory.eINSTANCE.createArgument();
      newArg.setValue("42.000");
      newArg.setOperation(rgoto);

      rgoto.setXCoordinate(newArg);
   }
   
   public static void swapXArgOfLastOperation(EObject root)
   {
      CAMModel model = (CAMModel) root;
      GOTO rgoto = (GOTO) model.getOperations().get(model.getOperations().size() - 1);

      Argument oldArg = rgoto.getXCoordinate();
      eMoflonEMFUtil.remove(oldArg);

      Argument newArg = CAMLanguageFactory.eINSTANCE.createArgument();
      newArg.setValue("42.000");
      newArg.setOperation(rgoto);

      rgoto.setXCoordinate(newArg);
   }
}
