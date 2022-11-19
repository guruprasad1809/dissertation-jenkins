def buildrepo = 'https://github.com/guruprasad1809/packer.git'

pipelineJob('ami-build-pipeline'){
    description('This pipeline is for building amis')

    parameters{
        choiceParam('buildrepo',[buildrepo], 'Git Repo')
        choiceParam('packerFile',['ubuntu.pkr.hcl','win1py.pkr.hcl'], 'Please choose a desired ami')
        stringParam('gitbranch', 'main' , 'Please enter the branch name')
    }

    definition{
        cps{
            script(readFileFromWorkspace('pipelines/ami-build.groovy'))
            sandbox()
        }
    }
}