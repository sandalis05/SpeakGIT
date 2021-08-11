package com.voice.impl;

import java.io.File;

import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.*;



public class BasicCommands {

	public static void main(String[] args) {

		Git git = null;
		/*
		 * git clone command
		 * 
		 * inputs:repo-URL
		 * 
		 */
		try {

			git = Git.cloneRepository().setURI("https://github.com/eclipse/jgit.git")
					.setDirectory(new File("/Users/priyal/eclipse-workspace/JGIT")).call();

			System.out.println("Git Clone Executed Successfully !!!");

		} catch (Exception e) {

			//System.out.println("Exception at " + e.getMessage());
			e.printStackTrace();
		}

		/*
		 * git init command
		 * 
		 * inputs:repo-URL
		 * 
		 */

		try  {
			git = Git.init().setDirectory(new File("/Users/priyal/eclipse-workspace/JGIT").call());

			System.out.println("Created a new repository at " + git.getRepository().getDirectory());

		} catch (Exception e) {

			//System.out.println("Exception at " + e.getMessage());
			e.printStackTrace();
		}

		/*
		 * git add command
		 * 
		 * inputs:repo-URL
		 * 
		 */

		try {
			AddCommand add = git.add();
			add.addFilepattern("someDirectory").call();
			
		} catch (InvalidRemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {

			//System.out.println("Exception at " + e.getMessage());
			e.printStackTrace();
		}

		/*
		 * git commit command
		 * 
		 * inputs:repo-URL
		 * 
		 */

		try {
			//git = new Git(db);
			CommitCommand commit = git.commit();
			commit.setMessage("initial commit").call();

		} /* catch (InvalidRemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */catch (Exception e) {

			//System.out.println("Exception at " + e.getMessage());
			e.printStackTrace();
		}

		/*
		 * git status command
		 * 
		 * inputs:repo-URL
		 * 
		 */

		try {

			Status status = git.status().call();
                System.out.println("Added: " + status.getAdded());
                System.out.println("Changed: " + status.getChanged());
                System.out.println("Conflicting: " + status.getConflicting());
                System.out.println("ConflictingStageState: " + status.getConflictingStageState());
                System.out.println("IgnoredNotInIndex: " + status.getIgnoredNotInIndex());
                System.out.println("Missing: " + status.getMissing());
                System.out.println("Modified: " + status.getModified());
                System.out.println("Removed: " + status.getRemoved());
                System.out.println("Untracked: " + status.getUntracked());
                System.out.println("UntrackedFolders: " + status.getUntrackedFolders());

		} catch (Exception e) {

			//System.out.println("Exception at " + e.getMessage());
			e.printStackTrace();
		}

		/*
		 * git config command
		 * 
		 * inputs:repo-URL
		 * 
		 */

		try {

			Config storedConfig = repository.getConfig();
            Set<String> remotes = storedConfig.getSubsections("remote");

            for (String remoteName : remotes) {
                String url = storedConfig.getString("remote", remoteName, "url");
                System.out.println(remoteName + " " + url);
			}

		} catch (Exception e) {

			//System.out.println("Exception at " + e.getMessage());
			e.printStackTrace();
		}

		/*
		 * git branch command
		 * 
		 * inputs:repo-URL
		 * 
		 */

		try {

			

		} catch (Exception e) {

			//System.out.println("Exception at " + e.getMessage());
			e.printStackTrace();
		}

		

	}
}
