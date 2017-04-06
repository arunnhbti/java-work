package com.arun.maven.goal;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * This goal will be responsible to create/update Function Control Configuration
 * file.
 * <p>
 *
 * @goal fcc
 */
public class FunctionControlConfigurationMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("=============Sample GOAL============");
    }

}
