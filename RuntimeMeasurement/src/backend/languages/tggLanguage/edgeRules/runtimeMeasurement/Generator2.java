package backend.languages.tggLanguage.edgeRules.runtimeMeasurement;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.moflon.util.eMoflonEMFUtil;

import ProcessDefinition.Invocation;
import ProcessDefinition.Module;
import ProcessDefinition.ProcessDefinitionFactory;
import ProcessDefinition.ProcessDefinitionPackage;
import ProcessDefinition.SystemModule;
import ProcessDefinition.Task;
import ProcessDefinition_EdgeRules.ProcessDefinition_EdgeRulesFactory;
import ProcessDefinition_EdgeRules.ProcessDefinition_EdgeRulesPackage;

/**
 * Generate a system module with n modules, each module contains 5 tasks and task i is connected to task i+1 with an
 * invocations. This generated test data is used to compare performance of node rules and edge rules in the case that an
 * integration can only be realized without edge rules by introducin nodification, in this case invocations are nodified.
 */
public class Generator2
{

   private static int multiplicator;

   public static void main(String[] args) throws IOException
   {
      FileUtils.deleteDirectory(new File("./resources/RuntimeMeasurement/"));
      FileUtils.forceMkdir(new File("./resources/RuntimeMeasurement/"));
      multiplicator = 10;
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
      /*
       * create modules
       */
      for (int i = 0; i < modules; i++)
      {
         Module module = f.createModule();
         module.setDescription(new Integer(i).toString());
         system.getAllModules().add(module);
         /*
          * create tasks
          */
         for (int j = 0; j < tasks; j++)
         {
            Task task = f.createTask();
            task.setId(new Integer(i).toString() + "_" + new Integer(j).toString());
            module.getTasks().add(task);
            system.getAllTasks().add(task);
         }
      }
      // add invocation of task j for task j-1
      for (int j = 1; j < system.getAllTasks().size(); j++)
      {
         Task task = system.getAllTasks().get(j - 1);

         Invocation invocation = f.createInvocation();
         task.getInvocations().add(invocation);
         invocation.setInvokedTask(system.getAllTasks().get(j));

      }
      eMoflonEMFUtil.saveModel(ProcessDefinitionPackage.eINSTANCE, system, "./resources/RuntimeMeasurement/nodeRules/" + modules / multiplicator + ".xmi");
   }

   public static void generateModelEdgeRules(int modules, int tasks)
   {
      ProcessDefinition_EdgeRulesFactory f = ProcessDefinition_EdgeRulesFactory.eINSTANCE;
      ProcessDefinition_EdgeRules.SystemModule system = f.createSystemModule();
      /*
       * create modules
       */
      for (int i = 0; i < modules; i++)
      {
         ProcessDefinition_EdgeRules.Module module = f.createModule();
         module.setDescription(new Integer(i).toString());
         system.getAllModules().add(module);
         /*
          * create tasks
          */
         for (int j = 0; j < tasks; j++)
         {
            ProcessDefinition_EdgeRules.Task task = f.createTask();
            task.setId(new Integer(i).toString() + "_" + new Integer(j).toString());
            module.getTasks().add(task);
            system.getAllTasks().add(task);
         }
      }
      // add invocation of task j for task j-1
      for (int j = 1; j < system.getAllTasks().size(); j++)
      {
         ProcessDefinition_EdgeRules.Task task = system.getAllTasks().get(j - 1);
         task.getInvocations().add(system.getAllTasks().get(j));
      }
      eMoflonEMFUtil.saveModel(ProcessDefinition_EdgeRulesPackage.eINSTANCE, system, "./resources/RuntimeMeasurement/edgeRules/" + modules / multiplicator
            + ".xmi");
   }

}
