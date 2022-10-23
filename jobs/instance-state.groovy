def instanceid =''
def region='eu-west-1'
pipelineJob('instance-state-management') {
    description('This pipeline is for instance state management')

    parameters{
        stringParam('region', region , 'Please enter the Instance ids')
        stringParam('instanceid', instanceid , 'Please enter the Instance ids')
        choiceParam('Action',['stop','start','terminate'], 'Please choose a desired action')
    }

    definition{
        cps{
            script(readFileFromWorkspace('pipelines/instance-start-stop.groovy'))
            sandbox()
        }
    }
}