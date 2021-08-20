import "../styles/styles.css"
import {MuiPickersUtilsProvider} from '@material-ui/pickers';
import LuxonUtils from '@date-io/luxon';

const _app = ({Component, pageProps}) => {
    return (
        <MuiPickersUtilsProvider utils={LuxonUtils}>
            <Component {...pageProps} />
        </MuiPickersUtilsProvider>
    )
}
export default _app
