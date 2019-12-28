import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockingTest {

    //To handle generics we must do like this
    @Mock
    List<String> typeToMock;
    String a;
    String b;

    @Test
    void testOfMockito() {

        // mock creation
        // List typeToMock = mock(List.class);

        // using mock object
        typeToMock.add("one");
        typeToMock.clear();

        // selective, explicit, highly readable verification
        verify(typeToMock, times(1)).add("one");
        verify(typeToMock).clear();

        // you can mock concrete classes, not only interfaces
        //LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        when(typeToMock.get(0)).thenReturn("first");

        // the following prints "first"
        System.out.println(typeToMock.get(0));

        // the following prints "null" because get(999) was not stubbed
        System.out.println(typeToMock.get(999));
    }

}

