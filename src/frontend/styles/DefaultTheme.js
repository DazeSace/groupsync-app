import {createTheme} from "@material-ui/core";
import Palette from "./Palette";
import '@fontsource/roboto/700.css';


const appBarMargin = 15

const DefaultTheme = createTheme({
    overrides: {
        MuiContainer: {
            root: {
                backgroundColor: Palette.palette.secondary.light,
            },
            maxWidthLg:{
              marginTop: 100
            },
            maxWidthXl: {
                background: Palette.palette.primary.main,
            }
        },
        MuiTypography: {
            h2: {
                color: Palette.palette.info.main,
                fontFamily: "Roboto",
                fontSize: "xx-large",
                marginTop: appBarMargin,
                marginBottom: appBarMargin
            }
        },
        MuiAppBar: {
            root: {
                background: Palette.palette.primary.main
            },
            colorDefault: {
                backgroundColor: Palette.palette.primary.main
            },
            colorSecondary: {
                background: "transparent"
            }

        }
    }
})

export default DefaultTheme