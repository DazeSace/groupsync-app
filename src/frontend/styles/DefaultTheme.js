import {createTheme} from "@material-ui/core";
import Palette from "./Palette";

const DefaultTheme = createTheme({
    overrides: {
        MuiContainer: {
            root: {
                background: Palette.palette.primary.main ,
            }
        }
    }
})

export default DefaultTheme