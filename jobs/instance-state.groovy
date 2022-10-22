pipelineJob('instance-state-management') {
    description('This pipeline is for instance state management')

    parameters{

        stringParam('instance id', instanceid , 'Please enter the Instance ids')
        choiceParam('Action',['stop','start','terminate'], 'Please choose a desired action')
    }

    definition{
        cps{
            script(readFileFromWorkspace('pipelines/instance-start-stop.groovy'))
            sandbox()
        }
    }
}