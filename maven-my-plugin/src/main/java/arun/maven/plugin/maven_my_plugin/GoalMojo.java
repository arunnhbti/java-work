package arun.maven.plugin.maven_my_plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * This goal will be responsible to create/update Function Control Configuration
 * file.
 * <p>
 *
 * @goal fcc
 */
@Mojo (name = "goalmojo", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class GoalMojo extends AbstractMojo
{

    public void execute() throws MojoExecutionException
    {
        System.out.println("==============SAMPLE==============");
    }
}
