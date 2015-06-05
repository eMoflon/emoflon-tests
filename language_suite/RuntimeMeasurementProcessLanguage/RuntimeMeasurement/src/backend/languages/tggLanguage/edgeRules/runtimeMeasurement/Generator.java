package backend.languages.tggLanguage.edgeRules.runtimeMeasurement;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.moflon.util.eMoflonEMFUtil;

import ProcessDefinition.Module;
import ProcessDefinition.ProcessDefinitionFactory;
import ProcessDefinition.ProcessDefinitionPackage;
import ProcessDefinition.SystemModule;
import ProcessDefinition.Task;
import ProcessDefinition_EdgeRules.ProcessDefinition_EdgeRulesFactory;
import ProcessDefinition_EdgeRules.ProcessDefinition_EdgeRulesPackage;

/**
 * Generate a system module with n modules, each module contains 5 tasks and no invocations.
 * This generated test data is used to compare performance of node rules and edge rules in the case
 * that an integration could also be realized without edge rules, i.e. edge rules are not needed.   
 */
public class Generator
{

   private static int multiplicator;

   public static void main(String[] args) throws IOException
   {
      FileUtils.deleteDirectory(new File("./resources/RuntimeMeasurement/"));
      FileUtils.forceMkdir(new File("./resources/RuntimeMeasurement/"));
      multiplicator = 5;
      for (int i = 1; i < 50; i++)
      {
         generateModelNodeRules(i * multiplicator, 5);
         generateModelEdgeRules(i * multiplicator, 5);
      }
   }

   public static void generateModelNodeRules(int modules, int tasks)
   {
      ProcessDefinitionFactory f = ProcessDefinitionFactory.eINSTANCE;
      SystemModule system = f.createSystemModule();
      for (int i = 0; i < modules; i++)
      {
         Module module = f.createModule();
         module.setDescription(new Integer(i).toString());
         system.getAllModules().add(module);
         for (int j = 0; j < tasks; j++)
         {
            Task task = f.createTask();
            task.setId(new Integer(j).toString());
            module.getTasks().add(task);
            system.getAllTasks().add(task);
         }
      }
      eMoflonEMFUtil.saveModel(ProcessDefinitionPackage.eINSTANCE, system, "./resources/RuntimeMeasurement/nodeRules/" + modules / multiplicator + ".xmi");
   }

   public static void generateModelEdgeRules(int modules, int tasks)
   {
      ProcessDefinition_EdgeRulesFactory f = ProcessDefinition_EdgeRulesFactory.eINSTANCE;
      ProcessDefinition_EdgeRules.SystemModule system = f.createSystemModule();
      for (int i = 0; i < modules; i++)
      {
         ProcessDefinition_EdgeRules.Module module = f.createModule();
         module.setDescription(new Integer(i).toString());
         system.getAllModules().add(module);
         for (int j = 0; j < tasks; j++)
         {
            ProcessDefinition_EdgeRules.Task task = f.createTask();
            task.setId(new Integer(j).toString());
            module.getTasks().add(task);
            system.getAllTasks().add(task);
         }
      }
      eMoflonEMFUtil.saveModel(ProcessDefinition_EdgeRulesPackage.eINSTANCE, system, "./resources/RuntimeMeasurement/edgeRules/" + modules / multiplicator
            + ".xmi");
   }

}
